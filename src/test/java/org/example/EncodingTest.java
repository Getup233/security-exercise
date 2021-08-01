package org.example;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author morse
 * @create 2021-07-28
 */
public class EncodingTest {

    @Test
    public void testBCryptPassword(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        $2a$10$F3TD7ErmxB3KDynfZRzARODI4YYVovpLZbpNnudavo1V74GR3UH9G
        String encode = encoder.encode("567abc");
//        $2a$10$5aW8ZZMIQwMRkavxeOn/AenBOT88NPDSvKRIC.HpuFrxJaR3FTw4.
        String encode1 = encoder.encode("567abc");
        System.out.println(encode);
        System.out.println(encode1);

        boolean check = encoder.matches("567abc", "$2a$10$F3TD7ErmxB3KDynfZRzARODI4YYVovpLZbpNnudavo1V74GR3UH9G");
        System.out.println(check);
    }
}
