package tp.orchestre.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpectateurAspect {
	
	@Pointcut("execution(* tp.orchestre.*.jouer(..))")
	public void monPointCut() {}
	
	@Before("monPointCut()")
	public void assoir() {
		System.out.println("Les spectateurs s'assoient");
	}
	
	@AfterReturning("monPointCut()")
	public void applaudir() {
		System.out.println("Les spectateurs applaudissent");
	}
	
	
	@AfterThrowing("monPointCut()")
	public void pasContent() {
		System.out.println("HOUUUUUUUUU REMBOURSEZZZZZ !!!");
	}
}
