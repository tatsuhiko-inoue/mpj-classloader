
import java.net.URL;
import java.net.URLClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import org.msgpack.MessagePack;

public class Main {
  public static void main(String[] args) throws Exception {
    URL[] urls = {new URL("file", "", new File("target/module").getAbsolutePath() + "/")};
    ClassLoader cl = new URLClassLoader(urls);

    Class<?> klassA = Class.forName("A", true, cl);
    Constructor<?> c = klassA.getConstructor();

    Object a = c.newInstance();

    MessagePack msgpack = new MessagePack();
    msgpack.setClassLoader(cl);

    msgpack.write(a);
  }
}
