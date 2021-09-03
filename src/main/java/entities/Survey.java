package entities;

public class Survey {
	private String recommendation;
	private String team;
	private String[] expect;
	private String comment;
	
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String[] getExpect() {
		return expect;
	}
	public void setExpect(String[] expect) {
		this.expect = expect;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
