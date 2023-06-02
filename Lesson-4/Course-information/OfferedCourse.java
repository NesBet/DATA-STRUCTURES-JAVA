class OfferedCourse extends Course {
   private String instructorName;
   private String location;
   private String classTime;

   public void setInstructorName(String name) {
      instructorName = name;
   }

   public void setLocation(String loc) {
      location = loc;
   }

   public void setClassTime(String time) {
      classTime = time;
   }

   public String getInstructorName() {
      return instructorName;
   }

   public String getLocation() {
      return location;
   }

   public String getClassTime() {
      return classTime;
   }
}
