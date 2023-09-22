-- Initialize the PRS database
DELETE from Requestlines;
DELETE from Requests;
DELETE from Products;
DELETE from Vendors;
DELETE from Users;
go

SET IDENTITY_INSERT Users ON;
go
INSERT [Users] (Id, Username, Password, Firstname, Lastname, Phone, Email, IsReviewer, IsAdmin) VALUES
				(1, 'sa', 'sa', 'System', 'Admin', '911', 'admin@system.com', 1, 1),
				(2, 'rv', 'rv', 'System', 'Reviewer', '711', 'reviewer@system.com', 1, 0),
				(3, 'us', 'us', 'System', 'User', '511', 'user@system.com', 0, 0);
go
SET IDENTITY_INSERT Users OFF;
go
SET IDENTITY_INSERT Vendors ON;
go
INSERT Vendors (Id, Code, Name, Address, City, State, Zip, Phone, Email) VALUES
				(1, 'AMAZ', 'Amazon', '1 Amazon Way', 'Seattle', 'WA', '48473', '800-Amazon1', 'info@amazon.com'),
				(2, 'BBUY', 'BestBuy', '444 Best Buy Dr', 'Atlanta', 'GA', '39474', '800-BestBuy', 'info@bestbuy.com'),
				(3, 'TARG', 'Target', '17 Target Cir', 'Minneapolis', 'MN', '54837', '800-Target7', 'info@target.com');
go
SET IDENTITY_INSERT Vendors OFF;
go
SET IDENTITY_INSERT Products ON;
go
INSERT Products (Id, PartNbr, Name, Price, Unit, VendorId) VALUES
				(1, 'ECHO', 'Amazon Echo', 100, 'Each', 1),
				(2, 'ECHODOT', 'Amazon Echo', 50, 'Each', 1),
				(3, 'ECHOSHOW', 'Amazon Show 5', 150, 'Each', 1),
				(4, 'IPAD', 'Apple iPad', 500, 'Each', 2),
				(5, 'MACBOOKPRO', 'Apple Macbook Pro', 2500, 'Each', 2),
				(6, 'EXTDRIVE', 'Seagate 1TB Ext Drive', 50, 'Each', 2),
				(7, 'PAPER', 'Paper 1 ream', 5, 'Each', 3),
				(8, 'PENS', 'Bic Pens 20ct', 10, 'Each', 3),
				(9, 'BINDER', 'Binder 1"', 15, 'Each', 3);
go
SET IDENTITY_INSERT Products OFF;
go
SET IDENTITY_INSERT Requests ON;
go
INSERT Requests (Id, [Description], Justification, DeliveryMode, [Status], Total, UserId) VALUES
                (1, 'Request 1 (sa)', 'None', 'Pickup', 'NEW', 50, 1),
                (2, 'Request 2 (rv)', 'None', 'Pickup', 'REVIEW', 150, 2),
                (3, 'Request 3 (us)', 'None', 'Pickup', 'NEW', 100, 3),
                (4, 'Request 4 (us)', 'None', 'Pickup', 'REVIEW', 150, 3),
                (5, 'Request 5 (us)', 'None', 'Pickup', 'NEW', 300, 3);
go
SET IDENTITY_INSERT Requests OFF;
GO
SET IDENTITY_INSERT Requestlines ON;
go
INSERT Requestlines (Id, RequestId, ProductId, Quantity) VALUES
                    (1, 1, 2, 1),
                    (2, 2, 1, 1),
                    (3, 2, 2, 1),
                    (4, 3, 1, 1),
                    (5, 3, 2, 1),
                    (6, 3, 3, 1);
go
SET IDENTITY_INSERT Requestlines OFF;
GO
SELECT * from Users;
SELECT * from Vendors;
SELECT * from Products;
SELECT * from Requests;
SELECT * from Requestlines;
go