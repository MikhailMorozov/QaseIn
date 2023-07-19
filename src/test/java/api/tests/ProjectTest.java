package api.tests;

import api.adapter.ProjectAdapter;
import api.models.Project;
import api.models.ProjectList;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestDataGenerator;

import static java.net.HttpURLConnection.HTTP_OK;

public class ProjectTest {

    private String nameProject = TestDataGenerator.generateNameProject();
    private String codeProject = TestDataGenerator.generateCodeProject();

    @Test
    public void getAllProjectsTest() {
        ProjectAdapter projectAdapter = new ProjectAdapter();
        Response response = projectAdapter.getAllProject();
        ProjectList projectList = new Gson().fromJson(response.asString(), ProjectList.class);
        Assert.assertEquals(projectList.isStatus(), true);
    }

    @Test
    public void postCreateNewProjectTest() {
        ProjectAdapter projectAdapter = new ProjectAdapter();
        Project project = new Project(nameProject, codeProject);
        String requestBody = new Gson().toJson(project);
        Response response = projectAdapter.postCreateNewProject(requestBody);
//        int statusCode = response.getStatusCode();
        Assert.assertEquals(response.getStatusCode(), HTTP_OK);
    }

    @Test (dependsOnMethods  = "postCreateNewProjectTest")
    public void deleteProjectTest() {
        ProjectAdapter projectAdapter = new ProjectAdapter();
//        Project project = new Project(nameProject, codeProject);
//        Gson gson = new Gson();
        String requestBody = new Gson().toJson(codeProject);
        Response response = projectAdapter.deleteProject(codeProject, requestBody);
//        int statusCode = response.getStatusCode();
        Assert.assertEquals(response.getStatusCode(), HTTP_OK);
    }


}
