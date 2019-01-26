#ifndef __ACCOUNT_EXCEPTION_H__
#define __ACCOUNT_EXCEPTION_H__

class MinusException
{
private:
	int exval;

public:
	MinusException(int val)
		:exval(val)
	{   }

	void ShowExceptionInfo(void) const
	{
		cout << "It's not valid amount" << endl;
	}
};

class InsuffException
{
private:
	int balance;
	int reqval;
public:
	InsuffException(int val, int req)
		:balance(val), reqval(req)
	{   }

	void ShowExceptionInfo() const
	{
		cout << "There's not enough balance. (" << reqval - balance << ")" << endl;
	}
};
#endif // !__ACCOUNT_EXCEPTION_H__
