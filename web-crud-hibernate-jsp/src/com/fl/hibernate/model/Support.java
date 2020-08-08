package com.fl.hibernate.model;


	

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "support")
public class Support {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int sId;
		
		@Column(name = "sname")
		private String sname;
		@Column(name = "semail")
		private String semail;
		@Column(name = "scountry")
		private String scountry;

		
		public Support() {
			super();
		}

		
		public Support(String sname, String semail, String scountry) {
			super();
			this.sname = sname;
			this.semail = semail;
			this.scountry = scountry;
		}


		public Support(int sId, String sname, String semail, String scountry) {
			super();
			this.sId = sId;
			this.sname = sname;
			this.semail = semail;
			this.scountry = scountry;
		}


		public int getsId() {
			return sId;
		}

		public void setsId(int sId) {
			this.sId = sId;
		}

		public String getSname() {
			return sname;
		}

		public void setSname(String sname) {
			this.sname = sname;
		}

		public String getSemail() {
			return semail;
		}

		public void setSemail(String semail) {
			this.semail = semail;
		}

		public String getScountry() {
			return scountry;
		}

		public void setScountry(String scountry) {
			this.scountry = scountry;
		}


		@Override
		public String toString() {
			return "Support [sId=" + sId + ", sname=" + sname + ", semail=" + semail + ", scountry=" + scountry + "]";
		}

		

}		
