

class Main {
  public static void main(String[] args) {
    Staff staff = new Staff();
    staff.listAll();
    System.out.println("\n\nand by role...");
    staff.listByRole("Construction Lead");
  }
}