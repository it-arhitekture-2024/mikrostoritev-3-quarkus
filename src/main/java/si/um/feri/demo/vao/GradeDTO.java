package si.um.feri.demo.vao;

public class GradeDTO {
    public String studentId;
    public String professorId;
    public String subjectId;
    public int gradeValue;
    public String description;


    public GradeDTO(Grade grade) {
        this.studentId = grade.studentId;
        this.professorId = grade.professorId;
        this.subjectId = grade.subjectId;
        this.gradeValue = grade.gradeValue;
        this.description = grade.description;
    }
}

