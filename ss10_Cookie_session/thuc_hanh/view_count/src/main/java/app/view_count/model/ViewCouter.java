package app.view_count.model;


public class ViewCouter {
    private int view;

    public ViewCouter() {
    }
    public ViewCouter(int view) {
        this.view = view;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public void viewIncrease(){
        this.view++;
    }
}
