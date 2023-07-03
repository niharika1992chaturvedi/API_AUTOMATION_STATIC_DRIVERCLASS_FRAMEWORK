package Test_Classes;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.Post_API_Methods;

import Common_API_Methods.Common_Utility_method;
import RequestRepoasitory.Post_Req_Repoasitory;

import io.restassured.path.json.JsonPath;
public class Post_Retry_TC1 {
	@Test

public static void extractor() throws IOException

{

for(int i=0; i<7; i++) {

int statusCode = Post_API_Methods.Responsestatuscode(

Post_Req_Repoasitory.BaseURI(),

Post_Req_Repoasitory.Post_Resource(),

Post_Req_Repoasitory.Post_Req_TC1());

if (statusCode==201)

{

System.out.println(statusCode);

String ResponseBody =Post_API_Methods.ResponseBody (

Post_Req_Repoasitory.BaseURI(),

Post_Req_Repoasitory.Post_Resource(),

Post_Req_Repoasitory.Post_Req_TC1());

System.out.println(ResponseBody);

String RequestBody= Post_Req_Repoasitory.Post_Req_TC1();

Common_Utility_method.EvidenceCreator("TC1",RequestBody,ResponseBody,statusCode);

validator(ResponseBody,RequestBody);

break;

}

else {

System.out.println("INVALID STATUS ");

}

}}

public static void validator(String ResponseBody,String RequestBody) {

JsonPath Jpost =new JsonPath(ResponseBody);

String post_res_name=Jpost.getString("name");

String post_res_job=Jpost.getString("job");

Assert.assertEquals(post_res_name, "morpheus");

Assert.assertEquals(post_res_job, "leader");

}

}