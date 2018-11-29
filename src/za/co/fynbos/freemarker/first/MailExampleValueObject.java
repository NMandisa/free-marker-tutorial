package za.co.fynbos.freemarker.first;

public class MailExampleValueObject {
		private String from;
		private String title;
		private String body;
		
		public MailExampleValueObject(){}
		public MailExampleValueObject(String from,String title,String body){
		this.from = from;
		this.title = title;
		this.body = body;
		}
		
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		
	
}
