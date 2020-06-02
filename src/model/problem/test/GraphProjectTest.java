package model.problem.test;

import model.problem.GraphProject;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class GraphProjectTest {

    private static GraphProject gp;

    @Before
    public void setUp() throws Exception {
        gp = new GraphProject("test");
        File fichier = new File("data/gpTest.prj");
        gp.fLoad(fichier);
    }

    @Test
    public void getName() {
        assertEquals("gpTest", gp.getName());
    }

    @Test
    public void getNbOr() {
        assertEquals(1, gp.getNbOr());
    }

    @Test
    public void getNbAnd() {
        assertEquals(1, gp.getNbAnd());
    }

    @Test
    public void getNbTasks() {
        assertEquals(4, gp.getNbTasks());
    }

    @Test
    public void getNbResources() {
        assertEquals(2, gp.getNbResources());
    }

    @Test
    public void getNbObjectives() {
        assertEquals(2, gp.getNbObjectives());
    }
}
