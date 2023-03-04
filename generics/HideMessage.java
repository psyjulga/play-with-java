package generics;

// generic class
// type parameters
public class HideMessage<Type> {
  private Type msg;

  // constructor
  public HideMessage(Type msg) {
    this.msg = msg;
  }

  public Type getMessage(String pw) {
    if (pw.equals("test"))
      return msg;
    else
      return null;
  }
}
