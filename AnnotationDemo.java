// custom annotation demo based on article from http://www.25hoursaday.com/CsharpVsJava.html#same
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented // annotation will show up in the javadoc
@Retention(RetentionPolicy.RUNTIME) // annotation metadata exposed at runtime
// special '@interface' annotation creation keyword
@interface AuthorInfo {
    String author();
    String email();
    String version() default "1.0";
}

@AuthorInfo(author="Andy Mender", email="andymenderunix@gmail.com")
class DummyClass {

}

class AnnotationDemo {
    public static void main(String[] args)
        throws Exception {
        // get Class object of DummyClass
        Class c = Class.forName("DummyClass");

        // get AuthorInfo metadata via the special annotation interface AuthorInfo
        // (requires an explicit cast!)
        AuthorInfo a = (AuthorInfo) c.getAnnotation(AuthorInfo.class);

        // print the metadata (requires calls to AuthorInfo methods!)
        System.out.println("Author information for " + c + ":");
        System.out.println("Author: " + a.author());
        System.out.println("Email: " + a.email());
        System.out.println("Version: " + a.version());
    }
}