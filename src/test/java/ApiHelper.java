import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ApiHelper extends ApiBase {

    ApiBase apiBaseToken;
    String userName = "Ronny";
    String password = "123Ron321&";

    public void createUser(String userName, String password){
        ApiLoginViewModel requestBody = ApiLoginViewModel.builder()
                .userName(userName)
                .password(password).
                build();
        postRequest("/Account/v1/User", 201, requestBody).jsonPath().getString("userID");
    }

    public String generateToken(String username, String password) {
        String endpoint = "/Account/v1/GenerateToken";
        ApiLoginViewModel userRequestBody = ApiLoginViewModel.builder()
                .userName(username).
                password(password).build();
        return postRequest(endpoint, 200, userRequestBody).jsonPath().getString("token");
    }


    public String getUserIdFromLogin(String userName, String password) {
        ApiLoginViewModel requestBody = ApiLoginViewModel.builder()
                .userName(userName)
                .password(password).
                build();
        return postRequest("/Account/v1/Login", 200, requestBody).jsonPath().getString("userId");
    }


    public void addOneBook(int bookIndex) {
        String token = generateToken(userName, password);
        apiBaseToken = new ApiBase(token);
        String userId = getUserIdFromLogin(userName, password);
        String isbn = getRequest("/BookStore/v1/Books", 200).body().jsonPath().getList("books", ApiBooksModel.class).get(bookIndex).getIsbn();

        ArrayList<Object> collection = new ArrayList<>();
        collection.add(new ApiIsbnsModel(isbn));

        ApiBookListModel reqBody = ApiBookListModel.builder()
                .userId(userId)
                .collectionOfIsbns(collection)
                .build();
        String isbnFromResponse = apiBaseToken.postRequest("/BookStore/v1/Books", 201, reqBody).getBody().jsonPath().getString("books[0].isbn");
        assertEquals(isbn, isbnFromResponse);
    }


    public void addTwoBooks(){
        String token = generateToken(userName, password);
        apiBaseToken = new ApiBase(token);
        String userId = getUserIdFromLogin(userName, password);

        List<ApiBooksModel> bookList = getRequest("/BookStore/v1/Books", 200).body().jsonPath().getList("books", ApiBooksModel.class);
        ArrayList<Object> requestCollection = new ArrayList<>();
        requestCollection.add(new ApiIsbnsModel(bookList.get(0).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(1).getIsbn()));

        ApiBookListModel reqBody = ApiBookListModel.builder()
                .userId(userId)
                .collectionOfIsbns(requestCollection)
                .build();
        apiBaseToken = new ApiBase(token);
        List<ApiIsbnsModel> responseCollection = apiBaseToken.postRequest("/BookStore/v1/Books", 201, reqBody)
                .getBody().
                jsonPath().
                getList("books", ApiIsbnsModel.class);
        assertEquals("ExpectedCollection does NOT correspond to responseCollection", requestCollection, responseCollection);
    }


    public void addThreeBooks(){
        String token = generateToken(userName, password);
        apiBaseToken = new ApiBase(token);
        String userId = getUserIdFromLogin(userName, password);

        List<ApiBooksModel> bookList = getRequest("/BookStore/v1/Books", 200).body().jsonPath().getList("books", ApiBooksModel.class);
        ArrayList<Object> requestCollection = new ArrayList<>();
        requestCollection.add(new ApiIsbnsModel(bookList.get(0).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(1).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(2).getIsbn()));

        ApiBookListModel reqBody = ApiBookListModel.builder()
                .userId(userId)
                .collectionOfIsbns(requestCollection)
                .build();
        apiBaseToken = new ApiBase(token);
        List<ApiIsbnsModel> responseCollection = apiBaseToken.postRequest("/BookStore/v1/Books", 201, reqBody)
                .getBody().
                jsonPath().
                getList("books", ApiIsbnsModel.class);
        assertEquals("ExpectedCollection does NOT correspond to responseCollection", requestCollection, responseCollection);
    }

    public void addListOfSixBooks() {
        String token = generateToken(userName, password);
        apiBaseToken = new ApiBase(token);
        String userId = getUserIdFromLogin(userName, password);

        List<ApiBooksModel> bookList = getRequest("/BookStore/v1/Books", 200).body().jsonPath().getList("books", ApiBooksModel.class);
        ArrayList<Object> requestCollection = new ArrayList<>();
        requestCollection.add(new ApiIsbnsModel(bookList.get(0).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(1).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(2).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(3).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(4).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(5).getIsbn()));

        ApiBookListModel reqBody = ApiBookListModel.builder()
                .userId(userId)
                .collectionOfIsbns(requestCollection)
                .build();
        apiBaseToken = new ApiBase(token);
        List<ApiIsbnsModel> responseCollection = apiBaseToken.postRequest("/BookStore/v1/Books", 201, reqBody)
                .getBody().
                jsonPath().
                getList("books", ApiIsbnsModel.class);
        assertEquals("ExpectedCollection does NOT correspond to responseCollection", requestCollection, responseCollection);
    }

    public void addEightBooks() {
        String token = generateToken(userName, password);
        apiBaseToken = new ApiBase(token);
        String userId = getUserIdFromLogin(userName, password);

        List<ApiBooksModel> bookList = getRequest("/BookStore/v1/Books", 200).body().jsonPath().getList("books", ApiBooksModel.class);
        ArrayList<Object> requestCollection = new ArrayList<>();
        requestCollection.add(new ApiIsbnsModel(bookList.get(0).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(1).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(2).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(3).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(4).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(5).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(6).getIsbn()));
        requestCollection.add(new ApiIsbnsModel(bookList.get(7).getIsbn()));

        ApiBookListModel reqBody = ApiBookListModel.builder()
                .userId(userId)
                .collectionOfIsbns(requestCollection)
                .build();
        apiBaseToken = new ApiBase(token);
        List<ApiIsbnsModel> responseCollection = apiBaseToken.postRequest("/BookStore/v1/Books", 201, reqBody)
                .getBody().
                jsonPath().
                getList("books", ApiIsbnsModel.class);
        assertEquals("ExpectedCollection does NOT correspond to responseCollection", requestCollection, responseCollection);
    }

    public void deleteAllBooks() {
        String token = generateToken(userName, password);
        String userId = getUserIdFromLogin(userName, password);
        apiBaseToken = new ApiBase(token);
        apiBaseToken.deleteRequestWithQuery("/BookStore/v1/Books", 204, userId);
    }
}




