import qrcode

url = "https://juanagogoo.github.io/"

qr = qrcode.make(url)

qr.save("codigo_qr.png")