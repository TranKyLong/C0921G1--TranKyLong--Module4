package app.ung_dung_muon_sach.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectAdvice {
    @AfterReturning(pointcut = "execution(* app.ung_dung_muon_sach.controller.BookController.returnBook(..))")
    public void logMethod1(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("\n**************************************************************** \n");
        System.out.println(" Phương thức " + methodName + " trả về kết quả bình thường ");
        System.out.println("các tham số là: " + args);
        System.out.println("\n**************************************************************** \n");
    }

    @AfterReturning(pointcut = "execution(* app.ung_dung_muon_sach.controller.BookController.confirm(..))")
    public void logMethod2(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("\n**************************************************************** \n");
        System.out.println(" Phương thức " + methodName + " trả về kết quả bình thường ");
        System.out.println("các tham số là: " + args);
        System.out.println("\n**************************************************************** \n");
    }
}
