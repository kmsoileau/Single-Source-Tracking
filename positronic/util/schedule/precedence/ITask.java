package positronic.util.schedule.precedence;

import positronic.satisfiability.naturalnumber.INaturalNumber;

public interface ITask
{
	INaturalNumber Completion();
	INaturalNumber Start();
}
