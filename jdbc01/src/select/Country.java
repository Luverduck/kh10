package select;

// DB에 한 줄을 옮겨 담을 수 있도록 필드를 구성
public class Country {

	// 필드
	private int rank;
	private String nation;
	private double score;
	
	// getter & setter
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	// toString 만들기 - 정보 출력을 쉽게 하기 위해
	@Override
	public String toString() {
		return "Country [rank=" + rank + ", nation=" + nation + ", score=" + score + "]";
	}
	
	
}
