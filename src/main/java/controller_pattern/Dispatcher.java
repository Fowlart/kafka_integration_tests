package controller_pattern;

public class Dispatcher {

    // Диспетчер знає про всі в"юхи. Його задача, віддати потрібну в"юху у відповідності до реквесту.
    private StudentView studentView;
    private HomeView homeView;

    public Dispatcher(){
        studentView = new StudentView();
        homeView = new HomeView();
    }

    public void dispatch(String request){
        if(request.equalsIgnoreCase("STUDENT")){
            studentView.show();
        }
        else{
            homeView.show();
        }
    }
}