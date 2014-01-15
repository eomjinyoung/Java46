package spms.test;

public class DependencyTest {

	class Student {
		//NoteBook nb = new NoteBook();
		NoteBook nb;
		public void setNoteBook(NoteBook nb) {
			this.nb = nb;
		}
		
		public void programming() {
			//use Notebook.
		}
		
	}
	
	class NoteBook {
		
	}
	
	public void init() {
		Student s1 = new Student();
		NoteBook n1 = new NoteBook();
		s1.setNoteBook(n1);
	}
	
	
	public static void main(String[] args) {
		

	}

}
