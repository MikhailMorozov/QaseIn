package api.adapter;

import io.restassured.response.Response;

import static utilities.Urls.PROJECT_API_URL;

public class ProjectAdapter extends BaseAdapter{

    public Response getAllProject() {
        return get(PROJECT_API_URL);
    }

    public Response postCreateNewProject(String body) {
        return post(PROJECT_API_URL, body);
    }

    public Response deleteProject(String body) {
        return delete(PROJECT_API_URL, body);
    }

}
