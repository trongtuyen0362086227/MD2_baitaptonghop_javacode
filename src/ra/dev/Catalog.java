package ra.dev;

import java.util.Scanner;

public class Catalog {
    private int CatalogID;
    private String CatalogName;
    private int Priority;
    private boolean CatalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogID, String catalogName, int priority, boolean catalogStatus) {
        CatalogID = catalogID;
        CatalogName = catalogName;
        Priority = priority;
        CatalogStatus = catalogStatus;
    }

    public int getCatalogID() {
        return CatalogID;
    }

    public void setCatalogID(int catalogID) {
        CatalogID = catalogID;
    }

    public String getCatalogName() {
        return CatalogName;
    }

    public void setCatalogName(String catalogName) {
        CatalogName = catalogName;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public boolean isCatalogStatus() {
        return CatalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        CatalogStatus = catalogStatus;
    }
    public void inputData(Scanner sc){
        System.out.println("nhap ma danh muc");
        this.CatalogID = Integer.parseInt(sc.nextLine());
        System.out.println("nhap ten danh muc");
        this.CatalogName = sc.nextLine();
        System.out.println("nhap do uu tien");
        this.Priority = Integer.parseInt(sc.nextLine());
        System.out.println("nhap trang thai danh muc");
        this.CatalogStatus = Boolean.parseBoolean(sc.nextLine());
    }
    public void displayData(){
        System.out.printf("ma danh muc: %d - ten danh muc: %s - do uu tien: %d - trang thai danh muc: %b\n",this.CatalogID,this.CatalogName,this.Priority,this.CatalogStatus);
    }
}
