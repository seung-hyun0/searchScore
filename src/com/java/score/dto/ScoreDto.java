package com.java.score.dto;

import java.util.Date;

public class ScoreDto {

	private int score_num; 			// 자동증가 번호
	private String name;			//이름
	private String stu_number;		// 학번
	private String year;			// 년도
	private String semester;		// 학기
	private int english;			// 영	
	private int math;			// 수
	private int social;			// 사
	private Date write_date;		// 입력날짜
	private double avg;				// 평균
	private int sum;				// 합계
	
	public ScoreDto() { }

	public ScoreDto(int score_num, String name, String stu_number, String year, String semester, int english, int math,
			int social, Date write_date, double avg, int sum) {
		super();
		this.score_num = score_num;
		this.name = name;
		this.stu_number = stu_number;
		this.year = year;
		this.semester = semester;
		this.english = english;
		this.math = math;
		this.social = social;
		this.write_date = write_date;
		this.avg = avg;
		this.sum = sum;
	}

	public int getScore_num() {
		return score_num;
	}

	public void setScore_num(int score_num) {
		this.score_num = score_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStu_number() {
		return stu_number;
	}

	public void setStu_number(String stu_number) {
		this.stu_number = stu_number;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "ScoreDto [score_num=" + score_num + ", name=" + name + ", stu_number=" + stu_number + ", year=" + year
				+ ", semester=" + semester + ", english=" + english + ", math=" + math + ", social=" + social
				+ ", write_date=" + write_date + ", avg=" + avg + ", sum=" + sum + "]";
	}

	
	
}
