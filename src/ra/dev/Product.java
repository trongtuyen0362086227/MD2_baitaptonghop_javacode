package ra.dev;

import java.util.Scanner;

public class Product {
    private String ProductID;
    private String ProductName;
    private String Title;
    private float ImportPrice;
    private float ExportPrice;
    private int Quantity;
    private String Depcription;
    private boolean ProductStatus;
    private Catalog catalog;

    public Product() {
    }

    public Product(String productID, String productName, String title, float importPrice, float exportPrice, int quantity, String depcription, boolean productStatus, Catalog catalog) {
        ProductID = productID;
        ProductName = productName;
        Title = title;
        ImportPrice = importPrice;
        ExportPrice = exportPrice;
        Quantity = quantity;
        Depcription = depcription;
        ProductStatus = productStatus;
        this.catalog = catalog;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public float getImportPrice() {
        return ImportPrice;
    }

    public void setImportPrice(float importPrice) {
        ImportPrice = importPrice;
    }

    public float getExportPrice() {
        return ExportPrice;
    }

    public void setExportPrice(float exportPrice) {
        ExportPrice = exportPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getDepcription() {
        return Depcription;
    }

    public void setDepcription(String depcription) {
        Depcription = depcription;
    }

    public boolean isProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(boolean productStatus) {
        ProductStatus = productStatus;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void inputData(Scanner sc, Catalog[] arrCatalog, int indexMax) {
        System.out.println("nhap ma san pham");
        this.ProductID = sc.nextLine();
        System.out.println("nhap ten san pham");
        this.ProductName = sc.nextLine();
        System.out.println("nhap tieu de san pham");
        this.Title = sc.nextLine();
        System.out.println("nhap gia nhap vao");
        this.ImportPrice = Float.parseFloat(sc.nextLine());
        System.out.println("nhap so luong con lai cua san pham");
        this.Quantity = Integer.parseInt(sc.nextLine());
        System.out.println("nhap vao mo ta san pham");
        this.Depcription = sc.nextLine();
        System.out.println("nhap trang thai san pham");
        this.ProductStatus = Boolean.parseBoolean(sc.nextLine());
        System.out.println("lua chon danh muc cho san pham");
        for (int i = 0; i < indexMax; i++) {
            System.out.printf("%d. %s\n", (i + 1), arrCatalog[i].getCatalogName());
        }
        System.out.print("lua chon cua ban la: ");
        int indexChoice = Integer.parseInt(sc.nextLine());
        this.catalog = arrCatalog[indexChoice-1];
    }

    public void dispayData() {
        System.out.printf("%-15s%-15s%-15s%-15f%-15f%-10d%-20s%-10b\n", this.ProductID, this.ProductName, this.Title,
                this.ImportPrice, this.ExportPrice, this.Quantity, this.Depcription, this.ProductStatus);
        String trangThai = "";
        if (this.ProductStatus) {
            trangThai = "Con ban";
        } else {
            trangThai = "Khong ban";
        }
        System.out.printf("Trang thai: %s - Danh muc: %s\n",trangThai,this.catalog.getCatalogName());
    }

    public void calExportPrice() {
        this.ExportPrice = this.ImportPrice * 1.2F;
    }
}
