package ra.run;

import ra.dev.Catalog;
import ra.dev.Product;

import java.util.Scanner;

public class ProductManage {
    static Product[] arrProduct = new Product[1000];
    static Catalog[] arrCatalog = new Catalog[100];
    static int indexProduct = 0;
    static int indexCatalog = 0;

    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("***********QUAN LY CUA HANG**********");
            System.out.println("1. quan ly danh muc");
            System.out.println("2. quan ly san pham");
            System.out.println("3. thoat");
            System.out.println("Su lua chon cua ban la");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    ProductManage.menuCatalog(sc);
                    break;
                case 2:
                    ProductManage.menuProduct(sc);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("vui long chon tu 1-3");
            }
        } while (true);
    }

    public static void menuCatalog(Scanner sc) {
        boolean exitMenuCatalog = true;
        do {
            System.out.println("***************QUAN LY DANH MUC*******************");
            System.out.println("1. Nhap thong tin danh muc");
            System.out.println("2. Hien thi thong tin danh muc theo do uu tien");
            System.out.println("3. Cap nhat thong tin danh muc");
            System.out.println("4. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choiceCatalog = Integer.parseInt(sc.nextLine());
            switch (choiceCatalog) {
                case 1:
                    ProductManage.inputListCatalog(sc);
                    break;
                case 2:
                    ProductManage.displayListCatalog();
                    break;
                case 3:
                    ProductManage.updateCatalog(sc);
                    break;
                case 4:
                    exitMenuCatalog = false;
                    break;
                default:
                    System.err.println("vui long chon tu 1-4");
            }

        } while (exitMenuCatalog);
    }

    public static void menuProduct(Scanner sc) {
        boolean exitMenuProduct = true;
        do {
            System.out.println("***************QUAN LY SAN PHAM**************");
            System.out.println("1. Nhap thong tin san pham");
            System.out.println("2. Tinh gia ban cho cac san pham");
            System.out.println("3. Hien thi thong tin san pham");
            System.out.println("4. Sap xep san pham theo gia ban tang dan");
            System.out.println("5. Tim kiem san pham theo ten san pham");
            System.out.println("6. Thong ke so luong va in thong tin san pham het hang");
            System.out.println("7. Cap nhat trang thai san pham theo ma san pham");
            System.out.println("8. Ban hang");
            System.out.println("9. Nhap hang");
            System.out.println("10. Thoat");
            System.out.print("Lua chon cua ban:");
            int choiceProduct = Integer.parseInt(sc.nextLine());
            switch (choiceProduct) {
                case 1:
                    ProductManage.inputListProduct(sc);
                    break;
                case 2:
                    ProductManage.calExportPriceListProduct();
                    break;
                case 3:
                    ProductManage.displayDataListproduct();
                    break;
                case 4:
                    ProductManage.sortListProduct();
                    break;
                case 5:
                    ProductManage.searchListProduct(sc);
                    break;
                case 6:
                    ProductManage.countProduct();
                    break;
                case 7:
                    ProductManage.updateStatusProduct(sc);
                    break;
                case 8:
                    ProductManage.banHang(sc);
                    break;
                case 9:
                    ProductManage.nhapHang(sc);
                    break;
                case 10:
                    exitMenuProduct = false;
                    break;
                default:
                    System.err.println("Vui long nhap tu 1-10");
            }
        } while (exitMenuProduct);

    }

    public static void inputListCatalog(Scanner sc) {
        System.out.println("nhap so danh muc can quan ly");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("nhap thong tin cho danh muc %d\n", (i + 1));
            arrCatalog[indexCatalog] = new Catalog();
            arrCatalog[indexCatalog].inputData(sc);
            indexCatalog++;
        }
    }

    public static void displayListCatalog() {
        for (int i = 0; i < indexCatalog - 1; i++) {
            for (int j = i + 1; j < indexCatalog; j++) {
                if (arrCatalog[i].getPriority() > arrCatalog[j].getPriority()) {
                    Catalog temp = arrCatalog[i];
                    arrCatalog[i] = arrCatalog[j];
                    arrCatalog[j] = temp;
                }
            }
        }
        for (int i = 0; i < indexCatalog; i++) {
            arrCatalog[i].displayData();
        }
    }

    public static void updateCatalog(Scanner sc) {
        System.out.println("nhap vao ma danh muc can cap nhat");
        int catalogIdUpdate = Integer.parseInt(sc.nextLine());
        int indexCatalogaupdate = -1;
        for (int i = 0; i < indexCatalog; i++) {
            if (arrCatalog[i].getCatalogID() == catalogIdUpdate) {
                indexCatalogaupdate = i;
                break;
            }
        }
        if (indexCatalogaupdate != -1) {
            System.out.println("nhap ten danh muc can cap nhat");
            String catalogName = sc.nextLine();
            if (catalogName != "" && catalogName.length() != 0) {
                arrCatalog[indexCatalogaupdate].setCatalogName(catalogName);
            }
            System.out.println("nhap vao do uu tien cua danh muc");
            String priority = sc.nextLine();
            if (priority != "" && priority.length() != 0) {
                arrCatalog[indexCatalogaupdate].setPriority(Integer.parseInt(priority));
            }
            System.out.println("Nhap vao trang thai danh muc");
            String status = sc.nextLine();
            if (status != "" && status.length() != 0) {
                arrCatalog[indexCatalogaupdate].setCatalogStatus(Boolean.parseBoolean(status));
            }
            System.out.println("da cap nhat xong cho danh muc");
        } else {
            System.out.println("khong tim thay san pham");
        }
    }

    public static void inputListProduct(Scanner sc) {
        System.out.println("nhap so luong san pham vao");
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            System.out.printf("nhap thong tin cho san pham %d\n", (i + 1));
            arrProduct[indexProduct] = new Product();
            arrProduct[indexProduct].inputData(sc, arrCatalog, indexCatalog);
            indexProduct++;
        }
    }

    public static void calExportPriceListProduct() {
        for (int i = 0; i < indexCatalog; i++) {
            arrProduct[i].calExportPrice();
        }
        System.out.println("Da tinh gia ban cho cac sp");
    }

    public static void displayDataListproduct() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-10s%-20s%-10s\n", "Product ID", "Product Name",
                "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status");
        for (int i = 0; i < indexProduct; i++) {
            arrProduct[i].dispayData();
        }
    }

    public static void sortListProduct() {
        for (int i = 0; i < indexProduct - 1; i++) {
            for (int j = i + 1; j < indexProduct; j++) {
                if (arrProduct[i].getExportPrice() > arrProduct[j].getExportPrice()) {
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("da sap xep sp tang dan theo gia ban");
    }

    public static void searchListProduct(Scanner sc) {
        System.out.println("nhap ten sp can tim kiem");
        String searchName = sc.nextLine();
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductName().startsWith(searchName)) {
                arrProduct[i].dispayData();
            }
        }
    }

    public static void countProduct() {
        int cnt = 0;
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-10s%-20s%-10s\n", "Product ID", "Product Name",
                "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status");
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getQuantity() <= 5) {
                cnt++;
                arrProduct[i].dispayData();
            }
        }
        System.out.printf("co %d san pham sap het hang\n", cnt);
    }

    public static void updateStatusProduct(Scanner sc) {
        System.out.println("nhap ma san pham can cap nhat");
        String strUpdate = sc.nextLine();
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductID().equals(strUpdate)) {
                arrProduct[i].setProductStatus(!arrProduct[i].isProductStatus());
            }
        }
        System.out.println("cap nhat trang thai san pham thanh cong\n");
    }

    public static void banHang(Scanner sc) {
        System.out.println("nhap ten san pham can mua");
        String sale = sc.nextLine();
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductName().equals(sale.trim())) {
                System.out.printf("%s con lai so luong: %d\n",arrProduct[i].getProductName(),arrProduct[i].getQuantity());
                System.out.println("so luong can mua");
                int soluong = Integer.parseInt(sc.nextLine());
                if (arrProduct[i].getQuantity()>=soluong){
                    arrProduct[i].setQuantity(arrProduct[i].getQuantity()-soluong);
                    System.out.println("da ban xong sn pham");
                } else {
                    System.out.println("so luong san pham con lai khong du");
                    break;
                }
                break;
            } else {
                System.out.println("khong tim thay san pham ban can mua");
                break;
            }
        }
    }


    public static void nhapHang(Scanner sc) {
        System.out.println("nhap ten hang can nhap vao");
        String hangnhap = sc.nextLine();
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductName().equals(hangnhap)) {
                System.out.println("so luong hang can nhap");
                int soluongnhap = Integer.parseInt(sc.nextLine());
                arrProduct[i].setQuantity(arrProduct[i].getQuantity() + soluongnhap);
                System.out.println("da nhap hang xong");
            } else {
                System.out.println("san pham khong ton tai tren he thong vui long nhap moi voi so luong ton kho bang so luong nhap vao");
                ProductManage.inputListProduct(sc);
                break;
            }
        }
    }
}

