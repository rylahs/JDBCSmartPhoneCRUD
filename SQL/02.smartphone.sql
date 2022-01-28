# 연산이 필요 없다고 판단 되는 것은 문자열로 처리

DROP TABLE IF EXISTS SmartPhone;
CREATE TABLE SmartPhone(
Product_Num INT AUTO_INCREMENT PRIMARY KEY, # 제품 번호 AUTO INCREMENT
Name VARCHAR(30) NOT NULL, # 제품명
Model VARCHAR(30) NOT NULL, # 모델번호
Price int, # 판매 가격
Company VARCHAR(12), #제조 회사
Screen double(4,2), # 화면 크기 cm
Resolution VARCHAR(30), # 해상도
Scan_Rate int, # 주사율
Ram int, # RAM
Disk int, # DISK 용량
Camera int, #Camera 후면 1카메라 화소
Battery int, #배터리 용량
Weight int #무게 g
);

insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("아이폰13 프로", "A2638", 1490000, "APPLE", 15.4, "2340x1080", 120, 6, 256, 1200, 3095, 203);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("아이폰13 미니", "A2628", 950000, "APPLE", 13.76, "2340x1080", 60, 4, 128, 1200, 2406, 140);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("아이폰12 프로", "A2407", 1350000, "APPLE", 15.49, "2532x1170", 60, 6, 128, 1200, 2815, 187);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("아이폰12 미니", "A2399", 1020000, "APPLE", 13.71, "2340x1080", 60, 4, 128, 1200, 2227, 133);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("아이폰SE 2세대", "A2296", 760000, "APPLE", 11.93, "1334x750", 60, 3, 64, 1200, 1821, 148);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("아이폰11 프로", "A2215", 1390000, "APPLE", 14.73, "2436x1125", 60, 4, 256, 1200, 3190, 188);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("아이폰11", "A2221", 990000, "APPLE", 15.49, "1792x828", 60, 4, 64, 1200, 3110, 194);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("갤럭시A52s", "SM-A528N", 599500, "삼성전자", 16.51, "2400x1080", 120, 6, 128, 6400, 4500, 189);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("갤럭시A32", "SM-A325N", 374000, "삼성전자", 16.25, "2400x1080", 90, 4, 64, 6400, 5000, 184);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("갤럭시Z 플립3", "SM-F711N", 1254000, "삼성전자", 17.01, "2640x1080", 120, 8, 256, 1200, 3300, 183);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("갤럭시Z 폴드3", "SM-F926N", 1998700, "삼성전자", 19.30, "2208x1768", 120, 12, 256, 1200, 4400, 271);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("갤럭시S21", "SM-G991N", 999900, "삼성전자", 15.74, "2400x1080", 120, 8, 256, 6400, 4000, 169);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("갤럭시S21 울트라", "SM-G998N", 1452000, "삼성전자", 17.27, "3200x1440", 120, 12, 256, 10800, 5000, 227);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("갤럭시노트20", "SM-N981N", 1199000, "삼성전자", 17.01, "2400x1080", 60, 8, 256, 6400, 4300, 192);
insert into SmartPhone (Name, Model, Price, Company, Screen, Resolution, Scan_Rate, Ram, Disk, Camera, Battery, Weight)
values ("갤럭시노트20 울트라", "SM-N986N", 1272570, "삼성전자", 17.52, "3088x1440", 120, 12, 256, 10800, 4500, 208);

Select * From SmartPhone;