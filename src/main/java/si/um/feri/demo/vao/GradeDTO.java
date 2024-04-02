package si.um.feri.demo.vao;

public class GradeDTO {
    public String studentId;
    public String professorId;
    public String subjectId;
    public int gradeValue;
    public String description;

    @Override
    public String toString() {
        return "\n    {\n" +
                "       studentId = '" + studentId + "',\n" +
                "       professorId = '" + professorId + "',\n" +
                "       subjectId = '" + subjectId + "',\n" +
                "       gradeValue = " + gradeValue + ",\n" +
                "       description = '" + description + "'\n" +
                '}';
    }


    public GradeDTO(Grade grade) {
        this.studentId = grade.studentId;
        this.professorId = grade.professorId;
        this.subjectId = grade.subjectId;
        this.gradeValue = grade.gradeValue;
        this.description = grade.description;
    }
}

