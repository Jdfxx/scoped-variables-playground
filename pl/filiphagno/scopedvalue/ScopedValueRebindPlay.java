package pl.filiphagno.scopedvalue;

import pl.filiphagno.user.User;

/*
 * Rebinding of Scoped Value is allowed
 */
public class ScopedValueRebindPlay {
    
    public static final ScopedValue<User> user = ScopedValue.newInstance();
    
    public static void main(String[] args) throws Exception {

        print("user is Bound => " + user.isBound());

        User bob = new User("bob");
        ScopedValue.where(user, bob).run(ScopedValueRebindPlay::handleUser);
                        
        print("user is Bound => " + user.isBound());
    }
    
    private static void handleUser() {
        
        print("handleUser - " + user.get());
        
        ScopedValue.where(user, new User("anonymous")).run(ScopedValueRebindPlay::callAsAnonymous);
        
        print("handleUser - " + user.get());
    }
    
    private static void callAsAnonymous() {
        print("callAsAnonymous - " + user.get());
   }

    public static void print(String m) {
        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), m);
    }
    
}
