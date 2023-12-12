import org.junit.Test;

public class BookStore_SortTest extends BaseTest {

      @Test
    public void titleSort_A_Z() {
        bookStorePage.clickTitleHeader();
        bookStorePage.sortTitleA_Z();
    }

    @Test
    public void titleSort_Z_A(){
        bookStorePage.doubleClickTitleHeader();
        bookStorePage.sortTitleZ_A();
    }


    @Test
    public void authorSort_A_Z(){
        bookStorePage.clickAuthorHeader();
        bookStorePage.sortAuthorA_Z();
    }

    @Test
    public void authorSort_Z_A(){
        bookStorePage.doubleClickAuthorHeader();
       bookStorePage.sortAuthorZ_A();
    }

    @Test
    public void publisherSort_A_Z(){
        bookStorePage.clickPublisherHeader();
        bookStorePage.sortPublisherA_Z();
    }

    @Test
    public void publisherSort_Z_A(){
        bookStorePage.doubleClickPublisherHeader();
        bookStorePage.sortPublisherZ_A();
    }


}
