
public class Builder {
	public static void main(String[] args) {
		HouseBuilder hb = new TreeHouseBuilder();
		HouseEngineer engineer = new HouseEngineer(hb);
		engineer.buildHouse();
		
		System.out.println(engineer.getHouse());
	}
}

interface HouseBuilder {
	void buildBasement();
	void buildWalls();
	void buildRoof();
	House getHouse();
}

class House {
	private String basement, walls, roof;

	public String getBasement() {
		return basement;
	}

	public void setBasement(String basement) {
		this.basement = basement;
	}

	public String getWalls() {
		return walls;
	}

	public void setWalls(String walls) {
		this.walls = walls;
	}

	public String getRoof() {
		return roof;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append("The house's walls are ");
		result.append(walls);
		result.append(".\n");

		result.append("The roof is ");
		result.append(roof);
		result.append(".\n");
		
		result.append("The basement is ");
		result.append(basement);
		result.append(".\n");
		
		
		
		
		return result.toString();
	}
}

class TreeHouseBuilder implements HouseBuilder {
	
	private final House house;
	
	public TreeHouseBuilder() {
		house = new House();
	}

	public House getHouse() {
		return house;
	}

	@Override
	public void buildBasement() {
		house.setBasement("a ladder down to the ground");
	}

	@Override
	public void buildWalls() {
		house.setWalls("wooden planked with a tree cutting through one of the walls");
	}

	@Override
	public void buildRoof() {
		house.setRoof("a slightly sloped wooden roof angling up towards the tree");
	}
}

class HouseEngineer {
	
	private final HouseBuilder hb;
	
	public HouseEngineer(HouseBuilder hb) {
		this.hb = hb;
	}
	
	public House getHouse() {
		return hb.getHouse();
	}
	
	public void buildHouse() {
		hb.buildRoof();
		hb.buildWalls();
		hb.buildBasement();
	}
}