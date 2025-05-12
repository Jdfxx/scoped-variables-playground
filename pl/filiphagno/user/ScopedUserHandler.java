package pl.filiphagno.user;

import pl.filiphagno.scopedvalue.ScopedValuePlay;

public class ScopedUserHandler {

    public boolean handle() {
                
        boolean bound = ScopedValuePlay.user.isBound();
        print("handle - user is Bound => " + bound);

        if (bound) {
            User requestUser = ScopedValuePlay.user.get();
            print("handle - User => " + requestUser);
            
            // handle user 'requestUser'
        }
        
        return bound;
    }

    public static void print(String m) {
        ScopedValuePlay.print(m);
    }

}
