package api.tests;

import api.adapter.ProjectAdapter;
import api.models.ProjectList;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.net.HttpURLConnection.HTTP_OK;

public class ProjectTest {

    @Test
    public void getAllProjectsTest() {
        ProjectAdapter projectAdapter = new ProjectAdapter();
        Response response = projectAdapter.getAllProject();
        ProjectList projectList = new Gson().fromJson(response.asString(), ProjectList.class);
//        System.out.println(projectList.toString());
//        Assert.assertEquals(response.statusCode(), HTTP_OK);
        Assert.assertEquals(projectList.isStatus(), true);
    }


}
