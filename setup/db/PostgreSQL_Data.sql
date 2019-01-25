-- Passwords are BCrypted hashes here

INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('bot', 'bot', '$2a$10$XsmYz3.r.UaoCUe8yqFtzucoBgMl9oTpWqWlNgfqLQAqwxIDG90Zy', 'bot', '999999999',
            'j5cd2tz2f5iwp4s4ntfzrisiuykhd666', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('bot1', 'bot1', '$2a$10$9CkJxdKX/0QCLv3W.tCYlets3ic9SRTyWcU.ZoQBovAPpnwF.Z7Z6', 'bot1', '999999999',
            'j5cd2tz2f5iwp4s4ntfzrisiuykhd6u1', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot1'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('bot2', 'bot2', '$2a$10$H8oebEbRh6QbCiotnqSJSuOtTpM.0r1tvCEhY3isl9Q565HuHDf5y', 'bot2', '999999999',
            'j5cd2tz2f5iwp4s4ntfzrisiuykhd6u2', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot2'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('bot3', 'bot3', '$2a$10$d6jPrigTQEZ.LEma7FoP8uPjL7K1JXgZ8SvENCesuYujD5cOyGjq6', 'bot3', '999999999',
            'j5cd2tz2f5iwp4s4ntfzrisiuykhd6u3', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot3'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('bot4', 'bot4', '$2a$10$sQatXETrxRTvZd9owGFnY.gnY012.YR4Ok/0Qh9zBM5UCr6XJ/koy', 'bot4', '999999999',
            'j5cd2tz2f5iwp4s4ntfzrisiuykhd6u4', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot4'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('bot5', 'bot5', '$2a$10$PxSzimLo92TI8HYIiwtaZOgRAHOkFtbc9JtNnZWCw5Y/Q7E9oPOh2', 'bot5', '999999999',
            'j5cd2tz2f5iwp4s4ntfzrisiuykhd6u5', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot5'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('bot6', 'bot6', '$2a$10$6.xQ9og3ONUf2PZu5ut7BObLXNHRjqIGz7H8X8i5Hy8vv5scpc/qW', 'bot6', '999999999',
            'j5cd2tz2f5iwp4s4ntfzrisiuykhd6u6', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot6'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('bot7', 'bot7', '$2a$10$Vzzr7pSzbiBy9wlSa1/mNuTQC6sDT9Fzy2y8ljuyAxcXU59G33ZI2', 'bot7', '999999999',
            'j5cd2tz2f5iwp4s4ntfzrisiuykhd6u7', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot7'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('bot8', 'bot8', '$2a$10$6/5xGIvvei.ZY6FNEL4EmevRYWIYc7/8mSwSzljkfp.Uxi2RmGM6K', 'bot8', '999999999',
            'j5cd2tz2f5iwp4s4ntfzrisiuykhd6u8', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot8'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('bot9', 'bot9', '$2a$10$nBOjRvAdgxR5JYHIovxBoebXXTKG/kNeGlvWe9B/j8J/ofMeEoKjS', 'bot9', '999999999',
            'j5cd2tz2f5iwp4s4ntfzrisiuykhd6u9', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot9'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
VALUES ('bot10', 'bot10', '$2a$10$1/gpA3hqaabh.G7uqixSwuZ3vvJXsDJXLdaove3zBDJ.yo7L5VShO', 'bot10', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykhd610', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot10'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot11', 'bot11', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot11', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykhd600', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot11'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot12', 'bot12', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot12', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykhd600', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot12'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot13', 'bot13', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot13', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykhd601', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot13'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot14', 'bot14', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot14', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot14', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot14'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot15', 'bot15', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot15', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot15', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot15'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot16', 'bot16', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot16', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot16', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot16'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot17', 'bot17', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot17', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot17', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot17'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot18', 'bot18', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot18', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot18', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot18'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot19', 'bot19', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot19', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot19', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot19'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot20', 'bot20', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot20', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot20', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot20'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot21', 'bot21', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot21', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot21', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot21'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot22', 'bot22', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot22', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot22', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot22'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot23', 'bot23', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot23', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot23', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot23'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot24', 'bot24', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot24', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot24', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot24'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot25', 'bot25', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot25', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot25', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot25'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot26', 'bot26', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot26', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot26', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot26'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot27', 'bot27', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot27', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot27', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot27'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot28', 'bot28', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot28', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot28', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot28'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot29', 'bot29', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot29', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot29', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot29'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot30', 'bot30', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot30', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot30', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot30'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot31', 'bot31', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot31', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot31', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot31'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot32', 'bot32', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot32', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot32', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot32'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot33', 'bot33', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot33', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot33', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot33'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot34', 'bot34', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot34', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot34', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot34'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot35', 'bot35', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot35', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot35', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot35'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot36', 'bot36', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot36', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot36', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot36'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot37', 'bot37', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot37', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot37', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot37'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot38', 'bot38', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot38', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot38', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot38'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot39', 'bot39', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot39', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot39', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot39'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot40', 'bot40', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot40', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot40', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot40'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot41', 'bot41', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot41', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot41', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot41'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot42', 'bot42', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot42', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot42', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot42'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot43', 'bot43', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot43', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot43', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot43'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot44', 'bot44', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot44', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot44', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot44'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot45', 'bot45', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot45', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot45', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot45'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot46', 'bot46', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot46', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot46', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot46'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot47', 'bot47', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot47', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot47', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot47'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot48', 'bot48', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot48', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot48', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot48'), 'ROLE_USER');
INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE", "TOKEN", "EMAIL")
    VALUES ('bot49', 'bot49', '$2a$10$aEjX.wWW0959XWWaDMsFZOXRckrk/.CUguFUtWgvQn.TT/8OKDwOS', 'bot49', '999999999', 'j5cd2tz2f5iwp4s4ntfzrisiuykbot49', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY") VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='bot49'), 'ROLE_USER');



INSERT INTO "USERS"( "USER_NAME", "LOGIN", "PASSWORD", "BOT_NAME", "PHONE",
            "TOKEN", "EMAIL")
    VALUES ('admin', 'admin', '$2a$10$GAk2B9I6e.qUQRgdm3CoWe9/nyK3gmF388m2IJI3FJ958NtvbdTVC', 'admin', '999999999',
            'nyannyannyannyannyannyannyannyan', 'asdf@asdf.com');
INSERT INTO "AUTHORITIES"("USER_ID", "AUTHORITY")
    VALUES ((SELECT u."ID" FROM "USERS" u WHERE u."LOGIN"='admin'), 'ROLE_ADMIN');


INSERT INTO "SETTINGS"("ID", "VAL")
VALUES
  ('GAME_TURN_DELAY', '2000'),
  ('TRAINIG_BOT_LOGINS', 'bot,bot2,bot3,bot4,bot5,bot6,bot7,bot8,bot9,bot10,bot11,bot12,bot13,bot14,bot15,bot16,bot17,bot18,bot19,bot20,bot21,bot22,bot23,bot24,bot25,bot26,bot27,bot28,bot29,bot30,bot31,bot32,bot33,bot34,bot35,bot36,bot37,bot38,bot39,bot40,bot41,bot42,bot43,bot44,bot45,bot46,bot47,bot48,bot49'),
  ('PORT', '10040'),
  ('NEXT_GAME_TIME', '2019-01-14T15:37:23'),
  ('READING_TIMEOUT', '10000'),
  ('ERROR_RESPONSE_DELAY', '500'),
  ('STAT_ROWS_TO_SHOW', '30'),
  ('REGISTRATION_IS_OPEN', 'true'),
  ('MINIMAL_PLAYERS_NUMBER', '2'),
  ('MAXIMAL_PLAYERS_NUMBER', '50'),
  ('GAME_TURNS_LIMIT', '200');

-- admin/Hardcoded2014