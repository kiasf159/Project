#include "BankingDeclare.h"
#include "Account.h"

Account::Account(int ID, int money, char *name)
	:accID(ID), balance(money)
{
	cusName = new char[strlen(name) + 1];
	strcpy(cusName, name);
}

Account::Account(const Account &ref)
	:accID(ref.accID), balance(ref.balance)
{
	cusName = new char[strlen(ref.cusName) + 1];
	strcpy(cusName, ref.cusName);
}
Account& Account::operator=(const Account &ref) //difference from previous version
{
	accID = ref.accID;
	balance = ref.balance;
	delete[]cusName;
	cusName = new char[strlen(ref.cusName) + 1];
	strcpy(cusName, ref.cusName);
	return *this;
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

Account::~Account()
{
	delete[]cusName;
}
