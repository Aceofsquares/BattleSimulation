package simulator.bs.InanimateObjects;

public abstract class Item {
	protected String name;
	protected float weight;
	protected int cost;
	protected ItemType itemType;
	
	public Item(String name){
		this.name = name;
		weight = 0.0f;
		cost = 0;
		itemType = ItemType.NONE;
	}
	
	public Item(String name, float weight, int cost, ItemType itemType){
		this.name = name;
		this.weight = weight;
		this.cost = cost;
		this.itemType = itemType;
	}
	
	public int getCost(){
		return cost;
	}
	
	public float getWeight(){
		return weight;
	}
	
	public String getName(){
		return name;
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}
	
	public void setWeight(float weight){
		this.weight = weight;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public abstract String getDescription();
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("\n");
		sb.append(getDescription());
		sb.append("\n");
		sb.append("Weight: ");
		sb.append(weight);
		sb.append("\tCost: ");
		sb.append(cost);
		sb.append("\n");
		return sb.toString();
	}
}
