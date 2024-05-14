package si.um.feri.demo.vao;

import org.bson.types.ObjectId;

public class GradeDTO {
    public ObjectId id;
    public String studentId;
    public String professorId;
    public String subjectId;
    public int gradeValue;
    public String description;


    public GradeDTO(Grade grade) {
        this.id = grade.id;
        this.studentId = grade.studentId;
        this.professorId = grade.professorId;
        this.subjectId = grade.subjectId;
        this.gradeValue = grade.gradeValue;
        this.description = grade.description;
    }
}

