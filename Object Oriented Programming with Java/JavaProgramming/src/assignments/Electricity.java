package assignments;

interface SlabInterface {
	short SLAB_START[] = { 1, 101, 201, 501 };
	short SLAB_END[] = { 100, 200, 500, -1 };
	float RATE[] = { 6, 7, 8, 9 };

	void calculateAmount();

	byte getSlab(int units);
}

// Implement SlabInterface class in ElectricityConsumer class
class ElectricityConsumer implements SlabInterface {

	int units;

	// set unit
	public void setUnits(int units) {
		this.units = units;
	}

	// Implement the method of SlabInterface
	@Override
	public void calculateAmount() {
		// get slab from getSlab method
		int slab = getSlab(units);
		// calculate amount by multiplying units with rate of slab
		int amount = (int) (units * RATE[slab]);
		System.out.println("Monthly bill amount as per " + units + " is " + amount);

	}

	// Implement the method of SlabInterface
	@Override
	public byte getSlab(int units) {
		// loop to find slab
		for (byte i = 0; i < SLAB_START.length; i++) {
			// because last index value in SLAB_END is -1 (for above 500)
			if (i != SLAB_START.length - 1) {
				if (units >= SLAB_START[i] && units <= SLAB_END[i])
					return i;
			}
			// then return value i
			else {
				return i;
			}
		}
		return 0;
	}

}

public class Electricity {

	public static void main(String[] args) {
		// Create object of ElectricityConsumer class
		ElectricityConsumer ec = new ElectricityConsumer();
		// And calculate amount for units
		ec.setUnits(50);
		ec.calculateAmount();
		ec.setUnits(150);
		ec.calculateAmount();
		ec.setUnits(200);
		ec.calculateAmount();
		ec.setUnits(250);
		ec.calculateAmount();
		ec.setUnits(550);
		ec.calculateAmount();
	}

}
