module.exports = function( grunt ) {

"use strict";

var max = [ "dist/jquery.color.js", "dist/jquery.color.svg-names.js" ],
	min = [ "dist/jquery.color.min.js", "dist/jquery.color.svg-names.min.js", "dist/jquery.color.plus-names.min.js" ],
	combined = "dist/jquery.color.plus-names.js",
	minify = {
		main: {
			options: {
				banner: "/*! jQuery Color v<%= pkg.version %> http://github.com/jquery/jquery-color | jquery.org/license */\n"
			},
			files: {}
		},
		svg: {
			options: {
				banner: "/*! jQuery Color v<%= pkg.version %> SVG Color Names http://github.com/jquery/jquery-color | jquery.org/license */\n"
			},
			files: {}
		},
		combined: {
			options: {
				banner: "/*! jQuery Color v<%= pkg.version %> with SVG Color Names http://github.com/jquery/jquery-color | jquery.org/license */\n"
			},
			files: {}
		}
	},
	concat = {};

minify.main.files[ min[ 0 ] ] = [ max[ 0 ] ];
minify.svg.files[ min[ 1 ] ] = [ max[ 1 ] ];
minify.combined.files[ min[ 2 ] ] = [ combined ];
concat[ combined ] = [ max[ 0 ], max[ 1 ] ];

require( "load-grunt-tasks" )( grunt );

grunt.initConfig( {
	pkg: grunt.file.readJSON( "package.json" ),

	tests: {
		jquery: [
			"git",
			"git.min"
		],
		"jquery-color": [
			"3.x-git",
			"3.x-git.min",
			"3.6.0",
			"3.5.1",
			"3.4.1",
			"3.3.1",
			"3.2.1",
			"3.1.1",
			"3.0.0",
			"2.2.4",
			"2.1.4",
			"2.0.3",
			"1.12.4",
			"1.11.3",
			"1.10.2",
			"1.9.1",
			"1.8.3",
			"1.7.2"
		]
	},

	bowercopy: {
		all: {
			options: {
				destPrefix: "external"
			},
			files: {
				"qunit/qunit.js": "qunit/qunit/qunit.js",
				"qunit/qunit.css": "qunit/qunit/qunit.css",
				"qunit/LICENSE.txt": "qunit/LICENSE.txt",

				"jquery-1.7.2/jquery.js": "jquery-1.7.2/jquery.js",
				"jquery-1.7.2/MIT-LICENSE.txt": "jquery-1.7.2/MIT-LICENSE.txt",

				"jquery-1.8.3/jquery.js": "jquery-1.8.3/jquery.js",
				"jquery-1.8.3/MIT-LICENSE.txt": "jquery-1.8.3/MIT-LICENSE.txt",

				"jquery-1.9.1/jquery.js": "jquery-1.9.1/jquery.js",
				"jquery-1.9.1/MIT-LICENSE.txt": "jquery-1.9.1/MIT-LICENSE.txt",

				"jquery-1.10.2/jquery.js": "jquery-1.10.2/jquery.js",
				"jquery-1.10.2/MIT-LICENSE.txt": "jquery-1.10.2/MIT-LICENSE.txt",

				"jquery-1.11.3/jquery.js": "jquery-1.11.3/dist/jquery.js",
				"jquery-1.11.3/MIT-LICENSE.txt": "jquery-1.11.3/MIT-LICENSE.txt",

				"jquery-1.12.4/jquery.js": "jquery-1.12.4/dist/jquery.js",
				"jquery-1.12.4/LICENSE.txt": "jquery-1.12.4/LICENSE.txt",

				"jquery-2.0.3/jquery.js": "jquery-2.0.3/jquery.js",
				"jquery-2.0.3/MIT-LICENSE.txt": "jquery-2.0.3/MIT-LICENSE.txt",

				"jquery-2.1.4/jquery.js": "jquery-2.1.4/dist/jquery.js",
				"jquery-2.1.4/MIT-LICENSE.txt": "jquery-2.1.4/MIT-LICENSE.txt",

				"jquery-2.2.4/jquery.js": "jquery-2.2.4/dist/jquery.js",
				"jquery-2.2.4/LICENSE.txt": "jquery-2.2.4/LICENSE.txt",

				"jquery-3.0.0/jquery.js": "jquery-3.0.0/dist/jquery.js",
				"jquery-3.0.0/LICENSE.txt": "jquery-3.0.0/LICENSE.txt",

				"jquery-3.1.1/jquery.js": "jquery-3.1.1/dist/jquery.js",
				"jquery-3.1.1/LICENSE.txt": "jquery-3.1.1/LICENSE.txt",

				"jquery-3.2.1/jquery.js": "jquery-3.2.1/dist/jquery.js",
				"jquery-3.2.1/LICENSE.txt": "jquery-3.2.1/LICENSE.txt",

				"jquery-3.3.1/jquery.js": "jquery-3.3.1/dist/jquery.js",
				"jquery-3.3.1/LICENSE.txt": "jquery-3.3.1/LICENSE.txt",

				"jquery-3.4.1/jquery.js": "jquery-3.4.1/dist/jquery.js",
				"jquery-3.4.1/LICENSE.txt": "jquery-3.4.1/LICENSE.txt",

				"jquery-3.5.1/jquery.js": "jquery-3.5.1/dist/jquery.js",
				"jquery-3.5.1/LICENSE.txt": "jquery-3.5.1/LICENSE.txt",

				"jquery-3.6.0/jquery.js": "jquery-3.6.0/dist/jquery.js",
				"jquery-3.6.0/LICENSE.txt": "jquery-3.6.0/LICENSE.txt"
			}
		}
	},

	eslint: {
		options: {

			// See https://github.com/sindresorhus/grunt-eslint/issues/119
			quiet: true
		},

		source: {
			src: [ "jquery.color.js", "jquery.color.svg-names.js" ]
		},
		grunt: {
			src: "Gruntfile.js"
		},
		test: {
			src: "test/unit/**"
		}
	},

	qunit: {
		files: "test/index.html",
		options: {
			puppeteer: {
				args: process.env.JENKINS_HOME ?
					[ "--no-sandbox", "--disable-setuid-sandbox" ] :
					[]
			}
		}
	},

	concat: concat,

	uglify: minify,

	compare_size: {
		"color": [ max[ 0 ], min[ 0 ] ],
		"svg-names": [ max[ 1 ], min[ 1 ] ],
		"combined": [ combined, min[ 2 ] ]
	}
} );


function gitDate( fn ) {
	grunt.util.spawn( {
		cmd: "git",
		args: [ "log", "-1", "--pretty=format:%ad" ]
	}, function( error, result ) {
		if ( error ) {
			grunt.log.error( error );
			return fn( error );
		}

		fn( null, result );
	} );
}

grunt.registerTask( "max", function() {
	var done = this.async(),
		version = grunt.config( "pkg.version" );

	if ( process.env.COMMIT ) {
		version += " " + process.env.COMMIT;
	}
	gitDate( function( error, date ) {
		if ( error ) {
			return done( false );
		}

		max.forEach( function( dist ) {
			grunt.file.copy( dist.replace( "dist/", "" ), dist, {
				process: function( source ) {
					return source
						.replace( /@VERSION/g, version )
						.replace( /@DATE/g, date );
				}
			} );
		} );


		done();
	} );
} );

grunt.registerTask( "testswarm", function( commit, configFile, projectName, browserSets,
	timeout ) {
	var config, tests,
		testswarm = require( "testswarm" ),
		runs = {},
		done = this.async();

	projectName = projectName || "jquerycolor";
	config = grunt.file.readJSON( configFile )[ projectName ];
	browserSets = browserSets || config.browserSets;
	if ( browserSets[ 0 ] === "[" ) {

		// We got an array, parse it
		browserSets = JSON.parse( browserSets );
	}
	timeout = timeout || 1000 * 60 * 15;

	tests = grunt.config( "tests" )[
		Array.isArray( browserSets ) ? browserSets[ 0 ] : browserSets ||
			"jquery" ];

	tests.forEach( function( jQueryVersion ) {
		runs[ jQueryVersion ] = config.testUrl + commit +
			"/test/index.html?jquery=" + jQueryVersion;
	} );

	testswarm.createClient( {
		url: config.swarmUrl
	} )
	.addReporter( testswarm.reporters.cli )
	.auth( {
		id: config.authUsername,
		token: config.authToken
	} )
	.addjob(
		{
			name: "Commit <a href='https://github.com/jquery/jquery-color/commit/" + commit + "'>" + commit.substr( 0, 10 ) + "</a>",
			runs: runs,
			runMax: config.runMax,
			browserSets: browserSets,
			timeout: timeout
		}, function( err, passed ) {
			if ( err ) {
				grunt.log.error( err );
			}
			done( passed );
		}
	);
} );

grunt.registerTask( "default", [
	"eslint",
	"bowercopy",
	"qunit",
	"build",
	"compare_size"
] );
grunt.registerTask( "build", [ "max", "concat", "uglify" ] );
grunt.registerTask( "ci", [ "eslint", "qunit" ] );

};
