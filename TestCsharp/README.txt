TESTING YOUR PRS C# CAPSTONE CODE

The code in this package is a tool that will programmatically test 
all the functions of your C# PRS Server code. 

The first thing to do is to run the SQL script that exists in the
SQL folder. This will erase all your existing data and put testing
data in your database.


To run the testing program called TestPrsServer, you need to extract
the zip file to any folder on your disk. Then open a command prompt by
holding the Windows key and pressing the letter 'R'. In the textbox, 
if it is not already there, type 'cmd' (without quotes) then click
OK. This will open a command prompt.

Make sure your C# code is running.

You'll need to change to the folder where the files were extracted.

At the command prompt:

	TestPrsServer --lang csharp --port xxxx

Replace the xxxx with the port number of your project. Then just
press enter. The test will complete in a matter of seconds, you'll
see an output that looks like this if all test are successful:

*****************************************************************
* MainDriver v1.3 - Test C# & Java API Controllers by Greg Doud
* Server language is csharp and port is 5555
*****************************************************************

TEST: [TestGetAllUsers               ]| <<< PASS >>> |
TEST: [TestAddUser                   ]| <<< PASS >>> | Code is 201
TEST: [TestGetUser                   ]| <<< PASS >>> |
TEST: [TestChangeUser                ]| <<< PASS >>> |
TEST: [TestLogin                     ]| <<< PASS >>> |
TEST: [TestRemoveUser                ]| <<< PASS >>> |
TEST: [TestGetAllUsers               ]| <<< PASS >>> |
TEST: [TestGetAllVendors             ]| <<< PASS >>> |
TEST: [TestAddVendor                 ]| <<< PASS >>> |
TEST: [TestGetVendor                 ]| <<< PASS >>> |
TEST: [TestChangeVendor              ]| <<< PASS >>> |
TEST: [TestRemoveVendor              ]| <<< PASS >>> |
TEST: [TestGetAllVendors             ]| <<< PASS >>> |
TEST: [TestGetAllProducts            ]| <<< PASS >>> |
TEST: [TestAddProduct                ]| <<< PASS >>> |
TEST: [TestGetProduct                ]| <<< PASS >>> |
TEST: [TestChangeProduct             ]| <<< PASS >>> |
TEST: [TestRemoveProduct             ]| <<< PASS >>> |
TEST: [TestGetAllProducts            ]| <<< PASS >>> |
TEST: [TestGetAllRequests            ]| <<< PASS >>> |
TEST: [TestAddRequest                ]| <<< PASS >>> | Read req id 36
TEST: [TestGetAllRequests            ]| <<< PASS >>> |
TEST: [TestGetRequest                ]| <<< PASS >>> |
TEST: [TestChangeRequest             ]| <<< PASS >>> |
TEST: [TestReviewRequest             ]| <<< PASS >>> |
TEST: [TestRejectRequest             ]| <<< PASS >>> |
TEST: [TestApproveRequest            ]| <<< PASS >>> |
TEST: [TestRemoveRequest             ]| <<< PASS >>> | Remove id 36
TEST: [TestGetAllRequests            ]| <<< PASS >>> |
TEST: [TestGetAllRequestsInReview    ]| <<< PASS >>> | UserId is 1
TEST: [TestGetAllRequestsInReview    ]| <<< PASS >>> | UserId is 2
TEST: [TestGetAllRequestsInReview    ]| <<< PASS >>> | UserId is 3
TEST: [TestGetAllRequestlines        ]| <<< PASS >>> |
TEST: [TestAddRequestline            ]| <<< PASS >>> | Read reql id 35
TEST: [TestGetRequestline            ]| <<< PASS >>> |
TEST: [TestChangeRequestline         ]| <<< PASS >>> |
TEST: [TestRemoveRequestline         ]| <<< PASS >>> | Remove id 35
Done ... press any key ...

If a test fails, you'll see <<<FAIL>>> next to the test.

When all the tests pass, you're done!