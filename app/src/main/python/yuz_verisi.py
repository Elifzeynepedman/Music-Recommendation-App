import cv2 # opencv kütüphanesi eklendi
vid_cam = cv2.VideoCapture(0) # kamera tanımlandı
# yüz tabanı için hazır bulunan sınıflandırıcı harcascade.xml dosyası dahil edildi
yuz_dedektor = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
# tanımlanan yüzleri ayırmak için farklı rakamlar atandı.
yuz_ismi = 3
# çekilecek fotoğraf adeti için değişken tanımlandı.
sayi = 1

while(True): # while döngüsü oluşturuldu.

    _,resim_cerceve = vid_cam.read() # kamera okutuldu.
    gri = cv2.cvtColor(resim_cerceve, cv2.COLOR_BGR2GRAY) # resim rengi için gri tonlama eklendi.
    yuzler = yuz_dedektor.detectMultiScale(gri, 1.3, 5) # resim için alt ve üst sınırlar belirlendi.

    for (x,y,w,h) in yuzler: # for döngüsünde çerçeve ebatları için değişkenler belirlendi.
        # cerceve kalınlığı ve rengi belirlendi.
        cv2.rectangle(resim_cerceve, (x-10,y-10), (x+w+10,y+h+10), (255,0,0), 2)
        sayi += 1 # fotoğraf adet artışı tanımlandı.
        # resimler veri klasörüne yazdırıldı.
        cv2.imwrite("veri/User." + str(yuz_ismi) + '.' + str(sayi) + ".jpg", gri[y:y+h,x:x+w])
        cv2.imshow('cerceve', resim_cerceve) # kameraya göster komutu atandı.
    # fotoğraf kalitesi belirlendi ve kameradan çıkış tuşu atandı.
    if cv2.waitKey(20) & 0xFF == ord('q'):
        break
    
    elif sayi>50: # kameranın çekeceği fotoğraf sayısı sınırlandırıldı.
        break

vid_cam.release() # kamera durduruldu.
cv2.destroyAllWindows() # tüm pencereler kapatıldı.
