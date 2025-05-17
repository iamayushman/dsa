package interview;

public class DbConnection {
  private static DbConnection connection = null;

  private DbConnection() {}

  public static DbConnection getInstance() {
    if (connection == null) {
      synchronized (DbConnection.class) {
        if (connection == null) {
          connection = new DbConnection();
        }
      }
    }
    return connection;
  }

  /*
   * S -> Single responsibility principle
   * O -> Open for extension closed for modification [✅]
   * L -> Liskov's Substitution principle
   * I -> Interface segmentation principle
   * D -> Dependency inversion principle
   * */
}
