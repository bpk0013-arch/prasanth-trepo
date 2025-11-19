# -*- mode: python ; coding: utf-8 -*-

block_cipher = None

a = Analysis(
    ['prasanth_trepo_gui_standalone.py'],
    pathex=[],
    binaries=[],
    datas=[],
    hiddenimports=[
        'reportlab',
        'reportlab.lib',
        'reportlab.lib.colors',
        'reportlab.lib.pagesizes',
        'reportlab.lib.styles',
        'reportlab.lib.units',
        'reportlab.lib.enums',
        'reportlab.platypus',
        'reportlab.graphics',
        'reportlab.graphics.shapes',
        'reportlab.graphics.charts',
        'reportlab.graphics.charts.barcharts',
        'reportlab.graphics.charts.linecharts',
        'reportlab.graphics.charts.piecharts',
        'openpyxl',
        'openpyxl.styles',
        'openpyxl.chart',
        'openpyxl.drawing',
        'openpyxl.drawing.image',
        'PIL',
        'PIL.Image',
    ],
    hookspath=[],
    hooksconfig={},
    runtime_hooks=[],
    excludes=[],
    win_no_prefer_redirects=False,
    win_private_assemblies=False,
    cipher=block_cipher,
    noarchive=False,
)

pyz = PYZ(a.pure, a.zipped_data, cipher=block_cipher)

exe = EXE(
    pyz,
    a.scripts,
    a.binaries,
    a.zipfiles,
    a.datas,
    [],
    name='Prasanth_TRepo_GUI_v2',
    debug=False,
    bootloader_ignore_signals=False,
    strip=False,
    upx=True,
    upx_exclude=[],
    runtime_tmpdir=None,
    console=False,  # No console window
    disable_windowed_traceback=False,
    argv_emulation=False,
    target_arch=None,
    codesign_identity=None,
    entitlements_file=None,
    icon=None,  # Add icon path if you have one
)
