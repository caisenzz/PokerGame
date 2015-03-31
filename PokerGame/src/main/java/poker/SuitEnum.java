package poker;

public enum SuitEnum {

  DIAMONDS("D",1),
  CLUBS("C",2),
  HEARTS("H",3),
  SPADES("S",4);
  
  private String code;
  
  //Rank is used to sort cards. 
  // Users can set this value and sort as what they want
  private int rank;
  
  private SuitEnum(String code,int rank){
	  this.code=code;
	  this.rank=rank;
  }
  
  public String getSuitCode(){
	  return this.code;
  }
  public int getRank(){
	  return this.rank;
  }
  public void setRank(int i){
	  this.rank=i;
  }
  
}
