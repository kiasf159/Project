//Control Class
#include "BankingDeclare.h"
#include "AccountHandler.h"
#include "Account.h"
#include "NormalAccount.h"
#include "CreditAccount.h"

void AccountHandler::ShowMenu(void) const
{
	cout << "-----Menu------" << endl;
	cout << "1. Opening an Account" << endl;
	cout << "2. Deposit" << endl;
	cout << "3. Withdrawal" << endl;
	cout << "4. Print out Account Information" << endl;
	cout << "5. Program Close." << endl;
}

void AccountHandler::Make_Account()
{
	int sel;
	cout << "[Type of Account]" << endl;
	cout << "1. Normal Account" << endl;
	cout << "2. Credit Account" << endl;
	cout << "Select : ";
	cin >> sel;

	if (sel == NORMAL)
		MakeNormalAccount();
	else
		MakeCreditAccount();
}

void AccountHandler::MakeNormalAccount()
{
	int id;
	char name[NAME_LEN];
	int balance;
	int interRate;

	cout << "[Opening an NormalAccount]" << endl;
	cout << "Account ID : ";
	cin >> id;
	cout << "Name : ";
	cin >> name;
	cout << "Deposit money : ";
	cin >> balance;
	cout << "interRate : ";
	cin >> interRate;
	cout << endl;

	accArr[accNum++] = new NormalAccount(id, balance, name, interRate);
}

void AccountHandler::MakeCreditAccount()
{
	int id;
	char name[NAME_LEN];
	int balance;
	int interRate;
	int credit_level;

	cout << "[Opening an NormalAccount]" << endl;
	cout << "Account ID : ";
	cin >> id;
	cout << "Name : ";
	cin >> name;
	cout << "Deposit money : ";
	cin >> balance;
	cout << "interRate : ";
	cin >> interRate;
	cout << "Credit Level(1 = A, 2 = B, 3 = C) : ";
	cin >> credit_level;
	cout << endl;

	switch (credit_level)
	{
	case 1:
		accArr[accNum++] = new CreditAccount(id, balance, name, interRate, LEVEL_A);
		break;
	case 2:
		accArr[accNum++] = new CreditAccount(id, balance, name, interRate, LEVEL_B);
		break;
	case 3:
		accArr[accNum++] = new CreditAccount(id, balance, name, interRate, LEVEL_C);
	}
}
void AccountHandler::Deposit_Money()
{
	int money;
	int id;
	cout << "[Deposit Corner]" << endl;
	cout << "Account ID : ";
	cin >> id;
	cout << "Deposit money : ";
	cin >> money;

	for (int i = 0; i < accNum; i++)
	{
		if (accArr[i]->GetAccID() == id)
		{
			accArr[i]->Deposit(money);
			cout << "Deposit Complete" << endl;
			return;
		}
	}
	cout << "It's not found. " << endl;
}

void AccountHandler::Withdraw_Money()
{
	int money;
	int id;
	cout << "[Withdrawal]" << endl;
	cout << "Account ID : ";
	cin >> id;
	cout << "Withdrawal money : ";
	cin >> money;

	for (int i = 0; i < accNum; i++)
	{
		if (accArr[i]->GetAccID() == id)
		{
			if (accArr[i]->Withdraw(money) == 0)
			{
				cout << "Balance Shortage.." << endl;
				return;
			}
			cout << "Withdrawal Complete" << endl;
			return;
		}
	}
	cout << "It's not found." << endl;
}

AccountHandler::AccountHandler()
	: accNum(0)
{  }

void AccountHandler::Account_Information_Output() const
{
	for (int i = 0; i < accNum; i++)
	{
		accArr[i]->ShowAccInfo();
		cout << endl;
	}
}

AccountHandler::~AccountHandler()
{
	for (int i = 0; i < accNum; i++)
		delete accArr[i];
}
