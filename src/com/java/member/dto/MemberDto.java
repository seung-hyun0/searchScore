package com.java.member.dto;

import java.util.Date;

/**
 * @개발자: 정승현
 * @작성일: 2019. 11. 6.
 * @설명 : 
 */
public class MemberDto {

		private int num;			// 자동 증가 번호
		private String id;			// 아이디
		private String pwd;			//비밀번호
		private String name;		//이름
		
		private String stu_number;	// 학번
		private String zipcode;		//우편번호
		
		private String address;		//주소
		private String job;			//직업
		
		
		
		public MemberDto() { }



		public MemberDto(int num, String id, String pwd, String name, String stu_number, String zipcode, String address,
				String job) {
			super();
			this.num = num;
			this.id = id;
			this.pwd = pwd;
			this.name = name;
			this.stu_number = stu_number;
			this.zipcode = zipcode;
			this.address = address;
			this.job = job;
		}



		public int getNum() {
			return num;
		}



		public void setNum(int num) {
			this.num = num;
		}



		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}



		public String getPwd() {
			return pwd;
		}



		public void setPwd(String pwd) {
			this.pwd = pwd;
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



		public String getZipcode() {
			return zipcode;
		}



		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}



		public String getAddress() {
			return address;
		}



		public void setAddress(String address) {
			this.address = address;
		}



		public String getJob() {
			return job;
		}



		public void setJob(String job) {
			this.job = job;
		}



		@Override
		public String toString() {
			return "MemberDto [num=" + num + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", stu_number="
					+ stu_number + ", zipcode=" + zipcode + ", address=" + address + ", job=" + job + "]";
		}
		
		
		
}
