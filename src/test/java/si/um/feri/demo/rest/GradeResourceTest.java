package si.um.feri.demo.rest;

import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import si.um.feri.demo.dao.GradeRepository;
import si.um.feri.demo.vao.Grade;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GradeResourceTest {

    @Test
    public void testListAllGrades() {
        Grade testGrade = new Grade();
        testGrade.studentId = "123";
        testGrade.professorId = "456";
        testGrade.subjectId = "789";
        testGrade.gradeValue = 8;
        testGrade.description = "Description1";


        GradeRepository gradeRepository = Mockito.mock(GradeRepository.class);
        when(gradeRepository.listAllGrades()).thenReturn(Uni.createFrom().item(Collections.singletonList(testGrade)));

        List<Grade> result = gradeRepository.listAllGrades().await().indefinitely();
        assertEquals(1, result.size());
        assertEquals(testGrade, result.getFirst());
    }
}
