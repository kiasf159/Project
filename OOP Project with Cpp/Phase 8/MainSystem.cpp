#include "BankingDeclare.h"
#include "AccountHandler.h"

int main()
{
	AccountHandler manager;
	int choice;

	while (1)
	{
		manager.ShowMenu();
		cout << "Choice : ";
		cin >> choice;
		cout << endl;

		switch (choice)
		{
		case MAKE:
			manager.Make_Account();
			break;
		case DEPOSIT:
			manager.Deposit_Money();
			break;
		case WITHDRAW:
			manager.Withdraw_Money();
			break;
		case INQUIRE:
			manager.Account_Information_Output();
			break;
		case EXIT:
			return 0;
		default:
			cout << "illegal selection..." << endl;
		}
	}
	return 0;
}
