package oop.method7;

public class Song {
	
	//필드 멤버
	String title;
	String singer;
	String album;
	int play;
	int heart;
	
	//설정 메소드 
	void setting(String title, String singer, String album, int play, int heart) {
		this.title = title;
		this.singer = singer;
		this.album = album;
		this.play = play;
		this.heart = heart;
	}
	
	//출력 메소드
	void print() {
		
		System.out.println("<음원 정보>");

		System.out.print("제목 : " + this.title);
		if(this.play > 100000) {
			System.out.print("(베스트)");
		}
		if(this.heart > 100000) {
			System.out.print("(인기곡)");
		}
		System.out.println();
		
		System.out.println("가수 : " + this.singer);
		
		System.out.println("앨범 : " + this.album);
		
		System.out.println("재생수 : " + this.play);
		
		System.out.println("좋아요수 : " + this.heart);
		
		int rankScore = (this.play * 2) + (this.heart / 2);
		
		System.out.println("랭킹 점수 : " + rankScore);
		System.out.println();
	}
}