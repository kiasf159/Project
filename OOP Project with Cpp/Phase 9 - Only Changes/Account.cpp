#include "BankingDeclare.h"
#include "Account.h"

Account::Account(int ID, int money, String name)
	:accID(ID), balance(money)
{
	cusName = name;
}

int Account::GetAccID() const
{
	return accID;
}

void Account::Deposit(int money)
{
	balance = balance + money;
}

int Account::Withdraw(int money)
{
	if (balance < money)
		return 0;
	balance = balance - money;
	return money;
}

void Account::ShowAccInfo() const
{
	cout << "Accout ID : " << accID << endl;
	cout << "Name : " << cusName << endl;
	cout << "Balance : " << balance << endl;
}
