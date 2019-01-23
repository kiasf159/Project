#ifndef __CREDIT_ACCOUNT_H__
#define __CREDIT_ACCOUNT_H__

#include "NormalAccount.h"
#include "String.h"

class CreditAccount : public NormalAccount
{
private:
	int specialRate;
public:
	CreditAccount(int ID, int money, String name, int rate, int special)
		:NormalAccount(ID, money, name, rate), specialRate(special)
	{  }

	virtual void Deposit(int money)
	{
		NormalAccount::Deposit(money);
		Account::Deposit(money*(specialRate / 100.0));
	}
};
#endif
